package com.mea.service;

import java.util.List;

import com.mea.entity.IPLPlayer;

public interface IPLPlayerMgmtService {
     public  String registerPayer(IPLPlayer player);
     public   IPLPlayer findPlayerById(int id);
     public  List<IPLPlayer>  findAllPlayers();
}
