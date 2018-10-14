package ru.home.pft.myfantasyleague.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Customizes extends ForwardingSet<CustomizeData> {

  private Set<CustomizeData> delegate;

  public Customizes(Customizes customizes) {
    this.delegate = new HashSet<CustomizeData>(customizes.delegate);
  }

  public Customizes() {
    this.delegate = new HashSet<CustomizeData>();
  }

  @Override
  protected Set<CustomizeData> delegate() {
    return delegate;
  }

  public Customizes withAdded(CustomizeData customize) {
    Customizes customizes = new Customizes(this);
    customizes.add(customize);
    return customizes;
  }

  public Customizes withOut(CustomizeData customize) {
    Customizes customizes = new Customizes(this);
    customizes.remove(customize);
    return customizes;
  }
}
