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
package ca.uqac.lif.cep.tmf;

import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Queue;

/**
 * Sink that remembers only the last event sent to it. This event can be queried
 * with {@link #getLast()}.
 * 
 * @author Sylvain Hallé
 * @since 0.2.1
 */
@SuppressWarnings("squid:S2160")
public class SinkLast extends Sink
{
  /**
   * The last event (or array of events) received
   */
  protected Object @Nullable [] m_last = null;

  /**
   * The number of events received so far
   */
  protected int m_eventCounter = 0;

  /**
   * Creates a new sink last processor
   */
  public SinkLast()
  {
    super();
  }

  /**
   * Creates a new sink last processor of given input arity
   * @param in_arity The input arity
   */
  public SinkLast(int in_arity)
  {
    super(in_arity);
  }

  @Override
  public void reset()
  {
    super.reset();
  }

  @Override
  protected boolean compute(Object[] inputs, Queue<Object[]> outputs)
  {
    m_last = inputs;
    return true;
  }

  @Pure
  public Object @Nullable [] getLast()
  {
    return m_last;
  }

  @Override
  @SideEffectFree
  public SinkLast duplicate(boolean with_state)
  {
    return new SinkLast(getInputArity());
  }
  
  /**
   * @since 0.10.2
   */
  public Object printState()
  {
    return getInputArity();
  }
  
  /**
   * @since 0.10.2
   */
  @Override
  public SinkLast readState(Object o)
  {
    return new SinkLast(((Number) o).intValue());
  }
}
