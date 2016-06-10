package com.jjfly.service;

import com.jjfly.common.FormatResponse;
import com.jjfly.domain.Showtime;
import com.jjfly.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luwin on 16-5-29.
 */
@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }
    @Override
    public FormatResponse getShowtimeList(long movieToCinemaId) {
        List<Showtime> showtimeList = showtimeRepository.findByMovieToCinemaId(movieToCinemaId);
        List<ModelMap> data = new ArrayList<>();
        for (Showtime showtimeItem: showtimeList) {
            ModelMap dataItem = new ModelMap();
            dataItem.addAttribute("showtimeId", showtimeItem.getId());
            dataItem.addAttribute("startTime", showtimeItem.getStartTime());
            dataItem.addAttribute("roomType", showtimeItem.getRoomType());
            dataItem.addAttribute("price", showtimeItem.getPrice());
            data.add(dataItem);
        }
        return new FormatResponse(200, "OK", data);
    }

    @Override
    public FormatResponse getShowtimeInfo(long showtimeId) {
        return new FormatResponse(200, "OK", showtimeRepository.findOne(showtimeId));
    }

    @Override
    public FormatResponse reserveSeat(long showtimeId, String seatStatus) {
        Showtime s = showtimeRepository.findOne(showtimeId);

        String oldSeatStatus = s.getSeatStatus();
        StringBuilder newSeatStatus = new StringBuilder();
        for (int i = 0; i < seatStatus.length(); i++) {
            //System.out.println(oldSeatStatus.indexOf(i));
            if (seatStatus.charAt(i) == '2') {
                System.out.println("PASS");
                if (oldSeatStatus.charAt(i) == '0') {
                    newSeatStatus.append(String.valueOf('1'));
                    continue;
                } else {
                    return new FormatResponse(400, "订票失败，座位已经被选", null);
                }
            }
            newSeatStatus.append(oldSeatStatus.charAt(i));
        }
        s.setSeatStatus(newSeatStatus.toString());
        showtimeRepository.save(s);
        return new FormatResponse(200, "OK", null);
    }
}
