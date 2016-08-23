package adl.test3;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.adl.runtime.Factories;
import org.adl.runtime.Factory;
import org.adl.runtime.JsonBinding;
import org.adl.runtime.JsonBindings;
import java.util.Objects;

public class A {

  /* Members */

  private short f_int;
  private String f_string;
  private boolean f_bool;

  /* Constructors */

  public A(short f_int, String f_string, boolean f_bool) {
    this.f_int = f_int;
    this.f_string = Objects.requireNonNull(f_string);
    this.f_bool = f_bool;
  }

  public A() {
    this.f_int = (short)0;
    this.f_string = "";
    this.f_bool = false;
  }

  public A(A other) {
    this.f_int = other.f_int;
    this.f_string = other.f_string;
    this.f_bool = other.f_bool;
  }

  /* Accessors and mutators */

  public short getF_int() {
    return f_int;
  }

  public void setF_int(short f_int) {
    this.f_int = f_int;
  }

  public String getF_string() {
    return f_string;
  }

  public void setF_string(String f_string) {
    this.f_string = Objects.requireNonNull(f_string);
  }

  public boolean getF_bool() {
    return f_bool;
  }

  public void setF_bool(boolean f_bool) {
    this.f_bool = f_bool;
  }

  /* Object level helpers */

  @Override
  public boolean equals(Object other0) {
    if (!(other0 instanceof A)) {
      return false;
    }
    A other = (A) other0;
    return
      f_int == other.f_int &&
      f_string.equals(other.f_string) &&
      f_bool == other.f_bool;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = result * 37 + (int) f_int;
    result = result * 37 + f_string.hashCode();
    result = result * 37 + (f_bool ? 0 : 1);
    return result;
  }

  /* Factory for construction of generic values */

  public static final Factory<A> FACTORY = new Factory<A>() {
    public A create() {
      return new A();
    }
    public A create(A other) {
      return new A(other);
    }
  };

  /* Json serialization */

  public static JsonBinding<A> jsonBinding() {
    final JsonBinding<Short> f_int = JsonBindings.SHORT;
    final JsonBinding<String> f_string = JsonBindings.STRING;
    final JsonBinding<Boolean> f_bool = JsonBindings.BOOLEAN;
    final Factory<A> _factory = FACTORY;

    return new JsonBinding<A>() {
      public Factory<A> factory() {
        return _factory;
      }

      public JsonElement toJson(A _value) {
        JsonObject _result = new JsonObject();
        _result.add("f_int", f_int.toJson(_value.f_int));
        _result.add("f_string", f_string.toJson(_value.f_string));
        _result.add("f_bool", f_bool.toJson(_value.f_bool));
        return _result;
      }

      public A fromJson(JsonElement _json) {
        JsonObject _obj = _json.getAsJsonObject();
        return new A(
          _obj.has("f_int") ? f_int.fromJson(_obj.get("f_int")) : (short)0,
          _obj.has("f_string") ? f_string.fromJson(_obj.get("f_string")) : "",
          _obj.has("f_bool") ? f_bool.fromJson(_obj.get("f_bool")) : false
        );
      }
    };
  }
}