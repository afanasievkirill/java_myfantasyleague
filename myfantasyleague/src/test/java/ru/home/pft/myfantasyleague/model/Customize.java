package ru.home.pft.myfantasyleague.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Customize extends ForwardingSet<CustomizeData> {

  private Set<CustomizeData> delegate;

  public Customize(Customize customize) {
    this.delegate = new HashSet<CustomizeData>(customize.delegate);
  }

  public Customize(){
    this.delegate = new HashSet<CustomizeData>();
  }

  @Override
  protected Set<CustomizeData> delegate() {
    return delegate;
  }

  public Customize withAdded(CustomizeData customizes){
    Customize customize = new Customize(this);
    customize.add(customizes);
    return customize;
  }

  public Customize withOut(CustomizeData customizes){
    Customize customize = new Customize(this);
    customize.remove(customizes);
    return customize;
  }
}
