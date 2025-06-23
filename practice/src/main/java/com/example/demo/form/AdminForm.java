package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AdminForm {

    @NotBlank(message = "姓を入力してください")
    private String lastName;

    @NotBlank(message = "名を入力してください")
    private String firstName;

    @NotBlank(message = "メールアドレスを入力してください")
    private String email;

    @NotBlank(message = "パスワードを入力してください")
    private String password;
}