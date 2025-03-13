package me.dio.barber_api.service;

import me.dio.barber_api.entity.ClientEntity;

import java.util.List;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);

}