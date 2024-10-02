package com.mea.service;

import java.util.List;

import com.mea.entity.IPLTeam;

public interface IPLTeamMgmtService {
     public  String registerIPLTeam(IPLTeam team);
     public   List<IPLTeam> getAllTeams();
     public    IPLTeam    getTeamById(int teamId);
}
