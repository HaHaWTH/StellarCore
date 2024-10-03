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
package github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic;

import github.kasuminova.stellarcore.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue;
import github.kasuminova.stellarcore.shaded.org.jctools.util.PortableJvmInfo;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.*;
import github.kasuminova.stellarcore.shaded.org.jctools.queues.*;
import static github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.AtomicQueueUtil.*;

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class // byte b160,b161,b162,b163,b164,b165,b166,b167;//120b
// byte b170,b171,b172,b173,b174,b175,b176,b177;//128b
// * drop 16b , the cold fields act as buffer *
BaseSpscLinkedAtomicArrayQueuePrePad<E> extends AbstractQueue<E> implements IndexedQueue {

    // 8b
    byte b000, b001, b002, b003, b004, b005, b006, b007;

    // 16b
    byte b010, b011, b012, b013, b014, b015, b016, b017;

    // 24b
    byte b020, b021, b022, b023, b024, b025, b026, b027;

    // 32b
    byte b030, b031, b032, b033, b034, b035, b036, b037;

    // 40b
    byte b040, b041, b042, b043, b044, b045, b046, b047;

    // 48b
    byte b050, b051, b052, b053, b054, b055, b056, b057;

    // 56b
    byte b060, b061, b062, b063, b064, b065, b066, b067;

    // 64b
    byte b070, b071, b072, b073, b074, b075, b076, b077;

    // 72b
    byte b100, b101, b102, b103, b104, b105, b106, b107;

    // 80b
    byte b110, b111, b112, b113, b114, b115, b116, b117;

    // 88b
    byte b120, b121, b122, b123, b124, b125, b126, b127;

    // 96b
    byte b130, b131, b132, b133, b134, b135, b136, b137;

    // 104b
    byte b140, b141, b142, b143, b144, b145, b146, b147;

    // 112b
    byte b150, b151, b152, b153, b154, b155, b156, b157;
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueueConsumerColdFields<E> extends BaseSpscLinkedAtomicArrayQueuePrePad<E> {

    protected long consumerMask;

    protected AtomicReferenceArray<E> consumerBuffer;
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueueConsumerField<E> extends BaseSpscLinkedAtomicArrayQueueConsumerColdFields<E> {

    private static final AtomicLongFieldUpdater<BaseSpscLinkedAtomicArrayQueueConsumerField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseSpscLinkedAtomicArrayQueueConsumerField.class, "consumerIndex");

    private volatile long consumerIndex;

    @Override
    public final long lvConsumerIndex() {
        return consumerIndex;
    }

    final long lpConsumerIndex() {
        return consumerIndex;
    }

    final void soConsumerIndex(long newValue) {
        C_INDEX_UPDATER.lazySet(this, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueueL2Pad<E> extends BaseSpscLinkedAtomicArrayQueueConsumerField<E> {

    // 8b
    byte b000, b001, b002, b003, b004, b005, b006, b007;

    // 16b
    byte b010, b011, b012, b013, b014, b015, b016, b017;

    // 24b
    byte b020, b021, b022, b023, b024, b025, b026, b027;

    // 32b
    byte b030, b031, b032, b033, b034, b035, b036, b037;

    // 40b
    byte b040, b041, b042, b043, b044, b045, b046, b047;

    // 48b
    byte b050, b051, b052, b053, b054, b055, b056, b057;

    // 56b
    byte b060, b061, b062, b063, b064, b065, b066, b067;

    // 64b
    byte b070, b071, b072, b073, b074, b075, b076, b077;

    // 72b
    byte b100, b101, b102, b103, b104, b105, b106, b107;

    // 80b
    byte b110, b111, b112, b113, b114, b115, b116, b117;

    // 88b
    byte b120, b121, b122, b123, b124, b125, b126, b127;

    // 96b
    byte b130, b131, b132, b133, b134, b135, b136, b137;

    // 104b
    byte b140, b141, b142, b143, b144, b145, b146, b147;

    // 112b
    byte b150, b151, b152, b153, b154, b155, b156, b157;

    // 120b
    byte b160, b161, b162, b163, b164, b165, b166, b167;

    // 128b
    byte b170, b171, b172, b173, b174, b175, b176, b177;
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueueProducerFields<E> extends BaseSpscLinkedAtomicArrayQueueL2Pad<E> {

    private static final AtomicLongFieldUpdater<BaseSpscLinkedAtomicArrayQueueProducerFields> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseSpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");

    private volatile long producerIndex;

    @Override
    public final long lvProducerIndex() {
        return producerIndex;
    }

    final void soProducerIndex(long newValue) {
        P_INDEX_UPDATER.lazySet(this, newValue);
    }

    final long lpProducerIndex() {
        return producerIndex;
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> extends BaseSpscLinkedAtomicArrayQueueProducerFields<E> {

    protected long producerBufferLimit;

    // fixed for chunked and unbounded
    protected long producerMask;

    protected AtomicReferenceArray<E> producerBuffer;
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is BaseSpscLinkedArrayQueue.java.
 */
abstract class BaseSpscLinkedAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {

    private static final Object JUMP = new Object();

    @Override
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        return IndexedQueueSizeUtil.size(this, IndexedQueueSizeUtil.PLAIN_DIVISOR);
    }

    @Override
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    @Override
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    protected final void soNext(AtomicReferenceArray<E> curr, AtomicReferenceArray<E> next) {
        int offset = nextArrayOffset(curr);
        soRefElement(curr, offset, next);
    }

    @SuppressWarnings("unchecked")
    protected final AtomicReferenceArray<E> lvNextArrayAndUnlink(AtomicReferenceArray<E> curr) {
        final int offset = nextArrayOffset(curr);
        final AtomicReferenceArray<E> nextBuffer = (AtomicReferenceArray<E>) lvRefElement(curr, offset);
        // prevent GC nepotism
        soRefElement(curr, offset, null);
        return nextBuffer;
    }

    @Override
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override
    public E relaxedPoll() {
        return poll();
    }

    @Override
    public E relaxedPeek() {
        return peek();
    }

    @Override
    public int drain(Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override
    public int fill(Supplier<E> s) {
        // result is a long because we want to have a safepoint check at regular intervals
        long result = 0;
        final int capacity = capacity();
        do {
            final int filled = fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (filled == 0) {
                return (int) result;
            }
            result += filled;
        } while (result <= capacity);
        return (int) result;
    }

    @Override
    public int drain(Consumer<E> c, int limit) {
        return MessagePassingQueueUtil.drain(this, c, limit);
    }

    @Override
    public int fill(Supplier<E> s, int limit) {
        if (null == s)
            throw new IllegalArgumentException("supplier is null");
        if (limit < 0)
            throw new IllegalArgumentException("limit is negative:" + limit);
        if (limit == 0)
            return 0;
        for (int i = 0; i < limit; i++) {
            // local load of field to avoid repeated loads after volatile reads
            final AtomicReferenceArray<E> buffer = producerBuffer;
            final long index = lpProducerIndex();
            final long mask = producerMask;
            final int offset = calcCircularRefElementOffset(index, mask);
            // expected hot path
            if (index < producerBufferLimit) {
                writeToQueue(buffer, s.get(), index, offset);
            } else {
                if (!offerColdPath(buffer, mask, index, offset, null, s)) {
                    return i;
                }
            }
        }
        return limit;
    }

    @Override
    public void drain(Consumer<E> c, WaitStrategy wait, ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, wait, exit);
    }

    @Override
    public void fill(Supplier<E> s, WaitStrategy wait, ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is correct for single producer thread use only.
     */
    @Override
    public boolean offer(final E e) {
        // Objects.requireNonNull(e);
        if (null == e) {
            throw new NullPointerException();
        }
        // local load of field to avoid repeated loads after volatile reads
        final AtomicReferenceArray<E> buffer = producerBuffer;
        final long index = lpProducerIndex();
        final long mask = producerMask;
        final int offset = calcCircularRefElementOffset(index, mask);
        // expected hot path
        if (index < producerBufferLimit) {
            writeToQueue(buffer, e, index, offset);
            return true;
        }
        return offerColdPath(buffer, mask, index, offset, e, null);
    }

    abstract boolean offerColdPath(AtomicReferenceArray<E> buffer, long mask, long pIndex, int offset, E v, Supplier<? extends E> s);

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is correct for single consumer thread use only.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E poll() {
        // local load of field to avoid repeated loads after volatile reads
        final AtomicReferenceArray<E> buffer = consumerBuffer;
        final long index = lpConsumerIndex();
        final long mask = consumerMask;
        final int offset = calcCircularRefElementOffset(index, mask);
        final Object e = lvRefElement(buffer, offset);
        boolean isNextBuffer = e == JUMP;
        if (null != e && !isNextBuffer) {
            // this ensures correctness on 32bit platforms
            soConsumerIndex(index + 1);
            soRefElement(buffer, offset, null);
            return (E) e;
        } else if (isNextBuffer) {
            return newBufferPoll(buffer, index);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is correct for single consumer thread use only.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        final AtomicReferenceArray<E> buffer = consumerBuffer;
        final long index = lpConsumerIndex();
        final long mask = consumerMask;
        final int offset = calcCircularRefElementOffset(index, mask);
        final Object e = lvRefElement(buffer, offset);
        if (e == JUMP) {
            return newBufferPeek(buffer, index);
        }
        return (E) e;
    }

    final void linkOldToNew(final long currIndex, final AtomicReferenceArray<E> oldBuffer, final int offset, final AtomicReferenceArray<E> newBuffer, final int offsetInNew, final E e) {
        soRefElement(newBuffer, offsetInNew, e);
        // link to next buffer and add next indicator as element of old buffer
        soNext(oldBuffer, newBuffer);
        soRefElement(oldBuffer, offset, JUMP);
        // index is visible after elements (isEmpty/poll ordering)
        // this ensures atomic write of long on 32bit platforms
        soProducerIndex(currIndex + 1);
    }

    final void writeToQueue(final AtomicReferenceArray<E> buffer, final E e, final long index, final int offset) {
        soRefElement(buffer, offset, e);
        // this ensures atomic write of long on 32bit platforms
        soProducerIndex(index + 1);
    }

    private E newBufferPeek(final AtomicReferenceArray<E> buffer, final long index) {
        AtomicReferenceArray<E> nextBuffer = lvNextArrayAndUnlink(buffer);
        consumerBuffer = nextBuffer;
        final long mask = length(nextBuffer) - 2;
        consumerMask = mask;
        final int offset = calcCircularRefElementOffset(index, mask);
        return lvRefElement(nextBuffer, offset);
    }

    private E newBufferPoll(final AtomicReferenceArray<E> buffer, final long index) {
        AtomicReferenceArray<E> nextBuffer = lvNextArrayAndUnlink(buffer);
        consumerBuffer = nextBuffer;
        final long mask = length(nextBuffer) - 2;
        consumerMask = mask;
        final int offset = calcCircularRefElementOffset(index, mask);
        final E n = lvRefElement(nextBuffer, offset);
        if (null == n) {
            throw new IllegalStateException("new buffer must have at least one element");
        } else {
            // this ensures correctness on 32bit platforms
            soConsumerIndex(index + 1);
            soRefElement(nextBuffer, offset, null);
            return n;
        }
    }
}
