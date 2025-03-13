package me.dio.barber_api.service.impl;

import lombok.AllArgsConstructor;
import me.dio.barber_api.entity.ScheduleEntity;
import me.dio.barber_api.repository.IScheduleRepository;
import me.dio.barber_api.service.IScheduleService;
import me.dio.barber_api.service.query.IScheduleQueryService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}