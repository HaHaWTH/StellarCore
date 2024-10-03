/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.*;
import github.kasuminova.stellarcore.shaded.org.jctools.queues.*;
import static github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.AtomicQueueUtil.*;
import github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.LinkedQueueAtomicNode;

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 */
abstract class BaseLinkedAtomicUnpaddedQueuePad0<E> extends AbstractQueue<E> implements MessagePassingQueue<E> {
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 */
abstract class BaseLinkedAtomicUnpaddedQueueProducerNodeRef<E> extends BaseLinkedAtomicUnpaddedQueuePad0<E> {

    private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicUnpaddedQueueProducerNodeRef, LinkedQueueAtomicNode> P_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicUnpaddedQueueProducerNodeRef.class, LinkedQueueAtomicNode.class, "producerNode");

    private volatile LinkedQueueAtomicNode<E> producerNode;

    final void spProducerNode(LinkedQueueAtomicNode<E> newValue) {
        P_NODE_UPDATER.lazySet(this, newValue);
    }

    final void soProducerNode(LinkedQueueAtomicNode<E> newValue) {
        P_NODE_UPDATER.lazySet(this, newValue);
    }

    final LinkedQueueAtomicNode<E> lvProducerNode() {
        return producerNode;
    }

    final boolean casProducerNode(LinkedQueueAtomicNode<E> expect, LinkedQueueAtomicNode<E> newValue) {
        return P_NODE_UPDATER.compareAndSet(this, expect, newValue);
    }

    final LinkedQueueAtomicNode<E> lpProducerNode() {
        return producerNode;
    }

    protected final LinkedQueueAtomicNode<E> xchgProducerNode(LinkedQueueAtomicNode<E> newValue) {
        return P_NODE_UPDATER.getAndSet(this, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 */
abstract class BaseLinkedAtomicUnpaddedQueuePad1<E> extends BaseLinkedAtomicUnpaddedQueueProducerNodeRef<E> {
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 */
abstract class BaseLinkedAtomicUnpaddedQueueConsumerNodeRef<E> extends BaseLinkedAtomicUnpaddedQueuePad1<E> {

    private static final AtomicReferenceFieldUpdater<BaseLinkedAtomicUnpaddedQueueConsumerNodeRef, LinkedQueueAtomicNode> C_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicUnpaddedQueueConsumerNodeRef.class, LinkedQueueAtomicNode.class, "consumerNode");

    private volatile LinkedQueueAtomicNode<E> consumerNode;

    final void spConsumerNode(LinkedQueueAtomicNode<E> newValue) {
        C_NODE_UPDATER.lazySet(this, newValue);
    }

    @SuppressWarnings("unchecked")
    final LinkedQueueAtomicNode<E> lvConsumerNode() {
        return consumerNode;
    }

    final LinkedQueueAtomicNode<E> lpConsumerNode() {
        return consumerNode;
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 */
abstract class BaseLinkedAtomicUnpaddedQueuePad2<E> extends BaseLinkedAtomicUnpaddedQueueConsumerNodeRef<E> {
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.unpadded.JavaParsingAtomicUnpaddedLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseLinkedQueue.java.
 *
 * A base data structure for concurrent linked queues. For convenience also pulled in common single consumer
 * methods since at this time there's no plan to implement MC.
 */
abstract class BaseLinkedAtomicUnpaddedQueue<E> extends BaseLinkedAtomicUnpaddedQueuePad2<E> {

    @Override
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    protected final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode<E>();
    }

    protected final LinkedQueueAtomicNode<E> newNode(E e) {
        return new LinkedQueueAtomicNode<E>(e);
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * This is an O(n) operation as we run through all the nodes and count them.<br>
     * The accuracy of the value returned by this method is subject to races with producer/consumer threads. In
     * particular when racing with the consumer thread this method may under estimate the size.<br>
     *
     * @see java.util.Queue#size()
     */
    @Override
    public final int size() {
        // Read consumer first, this is important because if the producer is node is 'older' than the consumer
        // the consumer may overtake it (consume past it) invalidating the 'snapshot' notion of size.
        LinkedQueueAtomicNode<E> chaserNode = lvConsumerNode();
        LinkedQueueAtomicNode<E> producerNode = lvProducerNode();
        int size = 0;
        // must chase the nodes all the way to the producer node, but there's no need to count beyond expected head.
        while (// don't go passed producer node
        chaserNode != producerNode && // stop at last node
        chaserNode != null && // stop at max int
        size < Integer.MAX_VALUE) {
            LinkedQueueAtomicNode<E> next;
            next = chaserNode.lvNext();
            // check if this node has been consumed, if so return what we have
            if (next == chaserNode) {
                return size;
            }
            chaserNode = next;
            size++;
        }
        return size;
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Queue is empty when producerNode is the same as consumerNode. An alternative implementation would be to
     * observe the producerNode.value is null, which also means an empty queue because only the
     * consumerNode.value is allowed to be null.
     *
     * @see MessagePassingQueue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        LinkedQueueAtomicNode<E> consumerNode = lvConsumerNode();
        LinkedQueueAtomicNode<E> producerNode = lvProducerNode();
        return consumerNode == producerNode;
    }

    protected E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> currConsumerNode, LinkedQueueAtomicNode<E> nextNode) {
        // we have to null out the value because we are going to hang on to the node
        final E nextValue = nextNode.getAndNullValue();
        // Fix up the next ref of currConsumerNode to prevent promoted nodes from keeping new ones alive.
        // We use a reference to self instead of null because null is already a meaningful value (the next of
        // producer node is null).
        currConsumerNode.soNext(currConsumerNode);
        spConsumerNode(nextNode);
        // currConsumerNode is now no longer referenced and can be collected
        return nextValue;
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Poll is allowed from a SINGLE thread.<br>
     * Poll is potentially blocking here as the {@link Queue#poll()} does not allow returning {@code null} if the queue is not
     * empty. This is very different from the original Vyukov guarantees. See {@link #relaxedPoll()} for the original
     * semantics.<br>
     * Poll reads {@code consumerNode.next} and:
     * <ol>
     * <li>If it is {@code null} AND the queue is empty return {@code null}, <b>if queue is not empty spin wait for
     * value to become visible</b>.
     * <li>If it is not {@code null} set it as the consumer node and return it's now evacuated value.
     * </ol>
     * This means the consumerNode.value is always {@code null}, which is also the starting point for the queue.
     * Because {@code null} values are not allowed to be offered this is the only node with it's value set to
     * {@code null} at any one time.
     *
     * @see MessagePassingQueue#poll()
     * @see java.util.Queue#poll()
     */
    @Override
    public E poll() {
        final LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return getSingleConsumerNodeValue(currConsumerNode, nextNode);
        } else if (currConsumerNode != lvProducerNode()) {
            nextNode = spinWaitForNextNode(currConsumerNode);
            // got the next node...
            return getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        return null;
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Peek is allowed from a SINGLE thread.<br>
     * Peek is potentially blocking here as the {@link Queue#peek()} does not allow returning {@code null} if the queue is not
     * empty. This is very different from the original Vyukov guarantees. See {@link #relaxedPeek()} for the original
     * semantics.<br>
     * Poll reads the next node from the consumerNode and:
     * <ol>
     * <li>If it is {@code null} AND the queue is empty return {@code null}, <b>if queue is not empty spin wait for
     * value to become visible</b>.
     * <li>If it is not {@code null} return it's value.
     * </ol>
     *
     * @see MessagePassingQueue#peek()
     * @see java.util.Queue#peek()
     */
    @Override
    public E peek() {
        final LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        } else if (currConsumerNode != lvProducerNode()) {
            nextNode = spinWaitForNextNode(currConsumerNode);
            // got the next node...
            return nextNode.lpValue();
        }
        return null;
    }

    LinkedQueueAtomicNode<E> spinWaitForNextNode(LinkedQueueAtomicNode<E> currNode) {
        LinkedQueueAtomicNode<E> nextNode;
        while ((nextNode = currNode.lvNext()) == null) {
            // spin, we are no longer wait free
        }
        return nextNode;
    }

    @Override
    public E relaxedPoll() {
        final LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        final LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        return null;
    }

    @Override
    public E relaxedPeek() {
        final LinkedQueueAtomicNode<E> nextNode = lpConsumerNode().lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        return null;
    }

    @Override
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override
    public int drain(Consumer<E> c, int limit) {
        if (null == c)
            throw new IllegalArgumentException("c is null");
        if (limit < 0)
            throw new IllegalArgumentException("limit is negative: " + limit);
        if (limit == 0)
            return 0;
        LinkedQueueAtomicNode<E> chaserNode = this.lpConsumerNode();
        for (int i = 0; i < limit; i++) {
            final LinkedQueueAtomicNode<E> nextNode = chaserNode.lvNext();
            if (nextNode == null) {
                return i;
            }
            // we have to null out the value because we are going to hang on to the node
            final E nextValue = getSingleConsumerNodeValue(chaserNode, nextNode);
            chaserNode = nextNode;
            c.accept(nextValue);
        }
        return limit;
    }

    @Override
    public int drain(Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override
    public void drain(Consumer<E> c, WaitStrategy wait, ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, wait, exit);
    }

    @Override
    public int capacity() {
        return UNBOUNDED_CAPACITY;
    }
}
