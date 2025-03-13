package me.dio.barber_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.dio.barber_api.controller.request.SaveScheduleRequest;
import me.dio.barber_api.controller.response.SaveScheduleResponse;
import me.dio.barber_api.controller.response.ScheduleAppointmentMonthResponse;
import me.dio.barber_api.mapper.IScheduleMapper;
import me.dio.barber_api.service.IScheduleService;
import me.dio.barber_api.service.query.IScheduleQueryService;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("schedules")
@AllArgsConstructor
public class ScheduleController {

    private final IScheduleService service;
    private final IScheduleQueryService queryService;
    private final IScheduleMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    SaveScheduleResponse save(@RequestBody @Valid SaveScheduleRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable final long id){
        service.delete(id);
    }

    @GetMapping("{year}/{month}")
    ScheduleAppointmentMonthResponse listMonth(@PathVariable final int year, @PathVariable final int month){
        var yearMonth = YearMonth.of(year, month);
        var startAt = yearMonth.atDay(1)
                .atTime(0, 0, 0, 0)
                .atOffset(UTC);
        var endAt = yearMonth.atEndOfMonth()
                .atTime(23, 59, 59, 999_999_999)
                .atOffset(UTC);
        var entities = queryService.findInMonth(startAt, endAt);
        return mapper.toMonthResponse(year, month, entities);
    }
}
