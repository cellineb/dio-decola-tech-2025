package me.dio.barber_api.service;

import me.dio.barber_api.entity.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);
    void delete(final long id);

}
