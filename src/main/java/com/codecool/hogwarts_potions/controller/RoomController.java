package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.Room;
import com.codecool.hogwarts_potions.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id){
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public Room updateRoomById(@PathVariable("id") Long id, @RequestBody Room updatedRoom){
        return roomService.updateRoomById(id, updatedRoom);
    }

    @DeleteMapping("/{id}")
    public String deleteRoomById(@PathVariable("id") Long id){
        roomService.deleteRoomById(id);
        return "Room is deleted";
    }

    //Get rooms where no cat or owl lives
    @GetMapping("/rat-owners")
    public List<Room> getRoomsForRatOwners(){
        return roomService.getRoomsForRatOwners();
    }
}
