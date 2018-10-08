package ru.home.pft.myfantasyleague.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Players extends ForwardingSet<PlayerData> {

  private Set<PlayerData> delegate;

  public Players(Players players) {
    this.delegate = new HashSet<PlayerData>(players.delegate);
  }

  public Players(){
    this.delegate = new HashSet<PlayerData>();
  }

  @Override
  protected Set<PlayerData> delegate() {
    return delegate;
  }

  public Players withAdded(PlayerData player){
    Players players = new Players(this);
    players.add(player);
    return players;
  }

  public Players without(PlayerData player){
    Players players = new Players(this);
    players.remove(player);
    return players;
  }
}
