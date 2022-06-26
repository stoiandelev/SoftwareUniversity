package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size medium, int labelId);
}
