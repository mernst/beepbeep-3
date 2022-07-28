/*
    BeepBeep, an event stream processor
    Copyright (C) 2008-2016 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.cep;

import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Associative map used by processors to store persistent data. In addition, all
 * operations on a `Context` object are synchronized.
 * 
 * @author Sylvain Hallé
 * @since 0.3
 *
 */
public class Context extends HashMap<String, @Nullable Object>
{
  /**
   * Dummy UID
   */
  private static final long serialVersionUID = 1L;

  /**
   * Creates a new empty context
   */
  public Context()
  {
    super();
  }

  /**
   * Creates a new context object from an existing one. This effectively
   * creates a copy of the context passed as parameter.
   * @param c The context object to copy from
   */
  public Context(Context c)
  {
    super();
    if (c != null)
    {
      putAll(c);
    }
  }

  @Override
  @SuppressWarnings({"squid:S1185",
          "nullness" // type inference failure
          })
  public synchronized void putAll(@UnknownInitialization(Context.class) Context this, Map<? extends String, ? extends @Nullable Object> o)
  {
    super.putAll(o);
  }

  @Override
  @SuppressWarnings("squid:S1185")
  public synchronized @Nullable Object get(@Nullable Object key)
  {
    return super.get(key);
  }

  @Override
  @SuppressWarnings("squid:S1185")
  public synchronized @Nullable Object put(String key, @Nullable Object value)
  {
    return super.put(key, value);
  }

  @Override
  @SuppressWarnings("squid:S1185")
  public synchronized boolean containsKey(@Nullable Object key)
  {
    return super.containsKey(key);
  }
}
