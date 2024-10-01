package com.spring3.series.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
