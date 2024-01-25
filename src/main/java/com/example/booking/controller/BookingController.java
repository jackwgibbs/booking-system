package com.example.booking.controller;

import com.example.booking.model.Appointment;
import com.example.booking.model.Staff;
import com.example.booking.model.User;
import com.example.booking.repository.AppointmentRepository;
import com.example.booking.repository.StaffRepository;
import com.example.booking.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BookingController {

    private StaffRepository staffRepository;
    private UserRepository userRepository;
    private AppointmentRepository appointmentRepository;

    public BookingController(AppointmentRepository appointmentRepository, StaffRepository staffRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.staffRepository = staffRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String getHome() {
        return "index";
    }

    @PostMapping("/submitAppointment")
    public String submitAppointment(@ModelAttribute("appointment") Appointment appointment) {
        // look up user
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        User user = null;
        if (optionalUser.get() != null) {
            user = optionalUser.get();
        }
        else{
            return "index";
        }

        // look up from either drop down or something
        Iterable<Staff> staffs = this.staffRepository.findAll();
        Staff staff = staffs.iterator().next();

        appointment.setStaff(staff);
        appointment.setUser(user);

        Appointment appointment1 = appointmentRepository.save(appointment);
        return "index";
    }

    @GetMapping("/myappointments")
    public String getMyAppointments(Model model) {
        Iterable<Appointment> appointments = this.appointmentRepository.findAll();
        model.addAttribute("appointments", appointments);
        return "appointments";
    }

}
