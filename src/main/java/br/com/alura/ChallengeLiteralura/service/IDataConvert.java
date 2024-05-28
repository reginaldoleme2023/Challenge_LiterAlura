package br.com.alura.ChallengeLiteralura.service;

public interface IDataConvert {
    <T> T  getData(String json, Class<T> classe);
}
