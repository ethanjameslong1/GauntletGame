import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item>
{
  private List<T> items;
  public Inventory(int slots)
  {
    items = new ArrayList<T>(slots);
  }

  public boolean setSlot(int slot, T item)
  {
    if (items.get(slot) == null)
    {
      items.set(slot, item);
      return true;
    }
    else return false;
  }
  public T getSlot(int slot)
  {
    return items.get(slot);
  }
  public int getSize()
  {
    return items.size();
  }
  public void emptySlot(int slot)
  {
    items.set(slot,null);
  }
  public void addWeapon(T weapon){
    if (items.size()!=0) System.out.println("Something's wrong");
    else items.add(weapon);
  }
}
