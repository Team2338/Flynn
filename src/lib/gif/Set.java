
package lib.gif;

import java.util.Enumeration;
import java.util.Vector;

/**
 * TODO: Change Vectors to ArrayLists
 * TODO: Change Enumerations to Iterators
 *
 * @author PatrickUbelhor
 */
public class Set<E> {
  Vector<E> set = new Vector<E>();

  public Set() {}

  public void add(E e) {
    if (set.contains(e))
      return;
    set.addElement(e);
  }

  public void add(Set<E> s) {
    Enumeration<E> stuff = s.getElements();
    for (Enumeration<E> e = stuff; e.hasMoreElements();) {
      add(e.nextElement());
    }
  }

  public boolean contains(Object o) {
    return set.contains(o);
  }

  public Enumeration<E> getElements() {
    return set.elements();
  }
}
