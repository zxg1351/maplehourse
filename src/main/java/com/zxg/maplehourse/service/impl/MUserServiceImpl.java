package com.zxg.maplehourse.service.impl;

import com.zxg.maplehourse.bean.ResultInfo;
import com.zxg.maplehourse.common.utils.SecurityUtil;
import com.zxg.maplehourse.model.MUserModel;
import com.zxg.maplehourse.repository.MUserRepository;
import com.zxg.maplehourse.service.MUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MUserServiceImpl implements MUserService {

    private static final Logger logger = LoggerFactory.getLogger(MUserServiceImpl.class);
    @Autowired
    private MUserRepository mUserRepository;

    @Value("${crypt.key}")
    private String cryptKey;

    @Override
    public ResultInfo selectAllUser() {

        ResultInfo resultInfo = new ResultInfo();

        List<MUserModel> mUserModelList = mUserRepository.findAll();

        if (!CollectionUtils.isEmpty(mUserModelList)) {

            resultInfo.setAppData(mUserModelList);
            logger.debug("用户列表信息显示");
        } else {
            logger.debug("暂无用户列表信息显示");
        }
        return resultInfo;
    }


    /**
     * 新建用户
     *
     * @param mUserModel
     * @return
     */
    @Override
    public ResultInfo saveUser(MUserModel mUserModel) {

        ResultInfo resultInfo = new ResultInfo();
        List<MUserModel> mUserModelList = checkUserAccountAndTel(mUserModel.getMUserAccount(), mUserModel.getMUserTel());

        if (CollectionUtils.isEmpty(mUserModelList)) {

            mUserModel.setCreateTime(new Date());
            mUserModel.setCreateUser(1);
            mUserModel.setDelFlag("0");
            try {
                String passWord = SecurityUtil.createSHA1(cryptKey.concat(SecurityUtil.decodeBase64(mUserModel.getMUserPassword())));
                mUserModel.setMUserPassword(passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MUserModel userModel = mUserRepository.save(mUserModel);

            resultInfo.setAppData(userModel);
            resultInfo.setResultCode("success");
        } else {
            resultInfo.setResultCode("failure");
            resultInfo.setResultMessage("该用户名或手机号已创建");
        }
        return resultInfo;
    }

    /**
     * 登录时,用户进行校验
     *
     * @param mUserModel
     * @return
     */
    @Override
    public ResultInfo checkUser(MUserModel mUserModel) {
        List<MUserModel> mUserModelList = new ArrayList<>();

        ResultInfo resultInfo = new ResultInfo();
        try {
            String passWord = SecurityUtil.createSHA1(cryptKey.concat(SecurityUtil.decodeBase64(mUserModel.getMUserPassword())));
            mUserModelList = mUserRepository.findByMUserAccountAndMUserPassword(mUserModel.getMUserAccount(), passWord);

            if (!CollectionUtils.isEmpty(mUserModelList)) {

                resultInfo.setResultCode("success");

            } else {
                resultInfo.setResultCode("failure");
                resultInfo.setResultMessage("该用户名不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultInfo;
    }

    @Override
    public Page<MUserModel> selectPageUser(Pageable pageable) {
        Page<MUserModel> modelPage = mUserRepository.findAll(pageable);


        return modelPage;
    }

    @Override
    public ResultInfo findById(Integer id) {

        ResultInfo resultInfo = new ResultInfo();
        MUserModel mUserModel = mUserRepository.findOne(id);
        resultInfo.setAppData(mUserModel);
        resultInfo.setResultMessage("查询成功");
        resultInfo.setResultCode("success");
        return resultInfo;
    }


    @Override
    public ResultInfo updateUser(MUserModel mUserModel) {

        ResultInfo resultInfo = new ResultInfo();
        mUserModel.setUpdateTime(new Date());
        mUserModel.setCreateUser(1);
        int userModel = mUserRepository.setmUesrName(mUserModel.getMUserName(),mUserModel.getMUserTel(),mUserModel.getId());
        resultInfo.setAppData(userModel);
        resultInfo.setResultCode("success");
        resultInfo.setResultMessage("");
        return resultInfo;
    }

    /**
     * 校验用户名和手机号码
     *
     * @param mUserAccount
     * @param mUserTel
     * @return
     */
    private List<MUserModel> checkUserAccountAndTel(String mUserAccount, String mUserTel) {


        List<MUserModel> mUserModelList = mUserRepository.findByMUserAccountOrMUserTel(mUserAccount, mUserTel);
        return mUserModelList;
    }
}
