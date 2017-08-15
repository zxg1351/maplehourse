package com.zxg.maplehourse.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2017/7/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

    private Float price;

    private String color;

    public static List<Apple> generateApples() {

        List<Float> prices = Arrays.asList(2.5f, 1.3f, 3.2f);

        List<String> colors = Arrays.asList("red", "green", "black");


        return prices.stream().flatMap(p -> colors.stream().map(c -> new Apple(p, c))).collect(toList());

    }

}
