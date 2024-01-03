package com.example.tube.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.NonNull;

public class TubeDto {

//    @UniqueLength
    //TODO доделать уникальную аннотацию для валидации
    private int length;

    private int price;

    public TubeDto() {
    }

    public TubeDto(int length, int price) {
        this.length = length;
        this.price = price;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NonNull
    @Min(value = 1, message = "min length")
    @Max(value = 20, message = "max length")
    public int getLength() {
        return length;
    }
    @NotNull
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "TubeDto{" +
                "length=" + length +
                ", price=" + price +
                '}';
    }
}
