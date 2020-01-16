package com.yawn.controller;

import com.yawn.entity.RequstEntity;
import com.yawn.entity.User;
import com.yawn.entity.VacTask;
import com.yawn.entity.Vacation;
import com.yawn.service.VacationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Created by yawn on 2018-01-08 13:42
 */
@RestController
public class VacationController {

    @Resource
    private VacationService vacationService;

    @PostMapping("/startVac")
    public Object startVac(@RequestBody Vacation vac, HttpSession session) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = vac.getUserName();
        }
        return vacationService.startVac(userName, vac);
    }

    @PostMapping("/myVac")
    public Object myVac(HttpSession session,@RequestBody RequstEntity requst) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = requst.getUserName();
        }
        return vacationService.myVac(userName);
    }

    @PostMapping("/myAudit")
    public Object myAudit(HttpSession session, @RequestBody RequstEntity requst) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = requst.getUserName();
        }
        return vacationService.myAudit(userName);
    }

    @PostMapping("/passAudit")
    public Object passAudit(HttpSession session, @RequestBody VacTask vacTask) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = vacTask.getUserName();
        }
        return vacationService.passAudit(userName, vacTask);
    }

    @PostMapping("/myVacRecord")
    public Object myVacRecord(HttpSession session,@RequestBody RequstEntity requst) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = requst.getUserName();
        }
        return vacationService.myVacRecord(userName);
    }

    @PostMapping("/myAuditRecord")
    public Object myAuditRecord(HttpSession session,@RequestBody RequstEntity requst) {
        String  userName = (String) session.getAttribute("userName");
        if(StringUtils.isBlank(userName)){
            userName = requst.getUserName();
        }
        return vacationService.myAuditRecord(userName);
    }

}
