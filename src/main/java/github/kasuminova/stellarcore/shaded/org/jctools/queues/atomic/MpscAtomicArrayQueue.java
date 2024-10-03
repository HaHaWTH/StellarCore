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

import java.util.concurrent.atomic.*;
import github.kasuminova.stellarcore.shaded.org.jctools.queues.*;
import static github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.AtomicQueueUtil.*;

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL1Pad<E> extends AtomicReferenceArrayQueue<E> {

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

    // byte b170,b171,b172,b173,b174,b175,b176,b177;//128b
    MpscAtomicArrayQueueL1Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueProducerIndexField<E> extends MpscAtomicArrayQueueL1Pad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerIndexField.class, "producerIndex");

    private volatile long producerIndex;

    MpscAtomicArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override
    public final long lvProducerIndex() {
        return producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return P_INDEX_UPDATER.compareAndSet(this, expect, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueMidPad<E> extends MpscAtomicArrayQueueProducerIndexField<E> {

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

    MpscAtomicArrayQueueMidPad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueProducerLimitField<E> extends MpscAtomicArrayQueueMidPad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerLimitField> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerLimitField.class, "producerLimit");

    // First unavailable index the producer may claim up to before rereading the consumer index
    private volatile long producerLimit;

    MpscAtomicArrayQueueProducerLimitField(int capacity) {
        super(capacity);
        this.producerLimit = capacity;
    }

    final long lvProducerLimit() {
        return producerLimit;
    }

    final void soProducerLimit(long newValue) {
        P_LIMIT_UPDATER.lazySet(this, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL2Pad<E> extends MpscAtomicArrayQueueProducerLimitField<E> {

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

    // byte b170,b171,b172,b173,b174,b175,b176,b177;//128b
    MpscAtomicArrayQueueL2Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueConsumerIndexField<E> extends MpscAtomicArrayQueueL2Pad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueConsumerIndexField.class, "consumerIndex");

    private volatile long consumerIndex;

    MpscAtomicArrayQueueConsumerIndexField(int capacity) {
        super(capacity);
    }

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
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL3Pad<E> extends MpscAtomicArrayQueueConsumerIndexField<E> {

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

    MpscAtomicArrayQueueL3Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 *
 * A Multi-Producer-Single-Consumer queue based on a {@link github.kasuminova.stellarcore.shaded.org.jctools.queues.ConcurrentCircularArrayQueue}. This
 * implies that any thread may call the offer method, but only a single thread may call poll/peek for correctness to
 * maintained. <br>
 * This implementation follows patterns documented on the package level for False Sharing protection.<br>
 * This implementation is using the <a href="http://sourceforge.net/projects/mc-fastflow/">Fast Flow</a>
 * method for polling from the queue (with minor change to correctly publish the index) and an extension of
 * the Leslie Lamport concurrent queue algorithm (originated by Martin Thompson) on the producer side.
 */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {

    public MpscAtomicArrayQueue(final int capacity) {
        super(capacity);
    }

    /**
     * {@link #offer}} if {@link #size()} is less than threshold.
     *
     * @param e         the object to offer onto the queue, not null
     * @param threshold the maximum allowable size
     * @return true if the offer is successful, false if queue size exceeds threshold
     * @since 1.0.1
     */
    public boolean offerIfBelowThreshold(final E e, int threshold) {
        if (null == e) {
            throw new NullPointerException();
        }
        final int mask = this.mask;
        final long capacity = mask + 1;
        long producerLimit = lvProducerLimit();
        long pIndex;
        do {
            pIndex = lvProducerIndex();
            long available = producerLimit - pIndex;
            long size = capacity - available;
            if (size >= threshold) {
                final long cIndex = lvConsumerIndex();
                size = pIndex - cIndex;
                if (size >= threshold) {
                    // the size exceeds threshold
                    return false;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    producerLimit = cIndex + capacity;
                    // this is racy, but the race is benign
                    soProducerLimit(producerLimit);
                }
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        /*
         * NOTE: the new producer index value is made visible BEFORE the element in the array. If we relied on
         * the index visibility to poll() we would need to handle the case where the element is not visible.
         */
        // Won CAS, move on to storing
        final int offset = calcCircularRefElementOffset(pIndex, mask);
        soRefElement(buffer, offset, e);
        // AWESOME :)
        return true;
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free offer using a single CAS. As class name suggests access is permitted to many threads
     * concurrently.
     *
     * @see java.util.Queue#offer
     * @see github.kasuminova.stellarcore.shaded.org.jctools.queues.MessagePassingQueue#offer
     */
    @Override
    public boolean offer(final E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        // use a cached view on consumer index (potentially updated in loop)
        final int mask = this.mask;
        long producerLimit = lvProducerLimit();
        long pIndex;
        do {
            pIndex = lvProducerIndex();
            if (pIndex >= producerLimit) {
                final long cIndex = lvConsumerIndex();
                producerLimit = cIndex + mask + 1;
                if (pIndex >= producerLimit) {
                    // FULL :(
                    return false;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    // this is racy, but the race is benign
                    soProducerLimit(producerLimit);
                }
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        /*
         * NOTE: the new producer index value is made visible BEFORE the element in the array. If we relied on
         * the index visibility to poll() we would need to handle the case where the element is not visible.
         */
        // Won CAS, move on to storing
        final int offset = calcCircularRefElementOffset(pIndex, mask);
        soRefElement(buffer, offset, e);
        // AWESOME :)
        return true;
    }

    /**
     * A wait free alternative to offer which fails on CAS failure.
     *
     * @param e new element, not null
     * @return 1 if next element cannot be filled, -1 if CAS failed, 0 if successful
     */
    public final int failFastOffer(final E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        final int mask = this.mask;
        final long capacity = mask + 1;
        final long pIndex = lvProducerIndex();
        long producerLimit = lvProducerLimit();
        if (pIndex >= producerLimit) {
            final long cIndex = lvConsumerIndex();
            producerLimit = cIndex + capacity;
            if (pIndex >= producerLimit) {
                // FULL :(
                return 1;
            } else {
                // update producer limit to the next index that we must recheck the consumer index
                soProducerLimit(producerLimit);
            }
        }
        // look Ma, no loop!
        if (!casProducerIndex(pIndex, pIndex + 1)) {
            // CAS FAIL :(
            return -1;
        }
        // Won CAS, move on to storing
        final int offset = calcCircularRefElementOffset(pIndex, mask);
        soRefElement(buffer, offset, e);
        // AWESOME :)
        return 0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free poll using ordered loads/stores. As class name suggests access is limited to a single thread.
     *
     * @see java.util.Queue#poll
     * @see github.kasuminova.stellarcore.shaded.org.jctools.queues.MessagePassingQueue#poll
     */
    @Override
    public E poll() {
        final long cIndex = lpConsumerIndex();
        final int offset = calcCircularRefElementOffset(cIndex, mask);
        // Copy field to avoid re-reading after volatile load
        final AtomicReferenceArray<E> buffer = this.buffer;
        // If we can't see the next available element we can't poll
        E e = lvRefElement(buffer, offset);
        if (null == e) {
            /*
             * NOTE: Queue may not actually be empty in the case of a producer (P1) being interrupted after
             * winning the CAS on offer but before storing the element in the queue. Other producers may go on
             * to fill up the queue after this element.
             */
            if (cIndex != lvProducerIndex()) {
                do {
                    e = lvRefElement(buffer, offset);
                } while (e == null);
            } else {
                return null;
            }
        }
        spRefElement(buffer, offset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    /**
     * {@inheritDoc}
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free peek using ordered loads. As class name suggests access is limited to a single thread.
     *
     * @see java.util.Queue#poll
     * @see github.kasuminova.stellarcore.shaded.org.jctools.queues.MessagePassingQueue#poll
     */
    @Override
    public E peek() {
        // Copy field to avoid re-reading after volatile load
        final AtomicReferenceArray<E> buffer = this.buffer;
        final long cIndex = lpConsumerIndex();
        final int offset = calcCircularRefElementOffset(cIndex, mask);
        E e = lvRefElement(buffer, offset);
        if (null == e) {
            /*
             * NOTE: Queue may not actually be empty in the case of a producer (P1) being interrupted after
             * winning the CAS on offer but before storing the element in the queue. Other producers may go on
             * to fill up the queue after this element.
             */
            if (cIndex != lvProducerIndex()) {
                do {
                    e = lvRefElement(buffer, offset);
                } while (e == null);
            } else {
                return null;
            }
        }
        return e;
    }

    @Override
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override
    public E relaxedPoll() {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final long cIndex = lpConsumerIndex();
        final int offset = calcCircularRefElementOffset(cIndex, mask);
        // If we can't see the next available element we can't poll
        E e = lvRefElement(buffer, offset);
        if (null == e) {
            return null;
        }
        spRefElement(buffer, offset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override
    public E relaxedPeek() {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final int mask = this.mask;
        final long cIndex = lpConsumerIndex();
        return lvRefElement(buffer, calcCircularRefElementOffset(cIndex, mask));
    }

    @Override
    public int drain(final Consumer<E> c, final int limit) {
        if (null == c)
            throw new IllegalArgumentException("c is null");
        if (limit < 0)
            throw new IllegalArgumentException("limit is negative: " + limit);
        if (limit == 0)
            return 0;
        final AtomicReferenceArray<E> buffer = this.buffer;
        final int mask = this.mask;
        final long cIndex = lpConsumerIndex();
        for (int i = 0; i < limit; i++) {
            final long index = cIndex + i;
            final int offset = calcCircularRefElementOffset(index, mask);
            final E e = lvRefElement(buffer, offset);
            if (null == e) {
                return i;
            }
            spRefElement(buffer, offset, null);
            // ordered store -> atomic and ordered for size()
            soConsumerIndex(index + 1);
            c.accept(e);
        }
        return limit;
    }

    @Override
    public int fill(Supplier<E> s, int limit) {
        if (null == s)
            throw new IllegalArgumentException("supplier is null");
        if (limit < 0)
            throw new IllegalArgumentException("limit is negative:" + limit);
        if (limit == 0)
            return 0;
        final int mask = this.mask;
        final long capacity = mask + 1;
        long producerLimit = lvProducerLimit();
        long pIndex;
        int actualLimit;
        do {
            pIndex = lvProducerIndex();
            long available = producerLimit - pIndex;
            if (available <= 0) {
                final long cIndex = lvConsumerIndex();
                producerLimit = cIndex + capacity;
                available = producerLimit - pIndex;
                if (available <= 0) {
                    // FULL :(
                    return 0;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    soProducerLimit(producerLimit);
                }
            }
            actualLimit = Math.min((int) available, limit);
        } while (!casProducerIndex(pIndex, pIndex + actualLimit));
        // right, now we claimed a few slots and can fill them with goodness
        final AtomicReferenceArray<E> buffer = this.buffer;
        for (int i = 0; i < actualLimit; i++) {
            // Won CAS, move on to storing
            final int offset = calcCircularRefElementOffset(pIndex + i, mask);
            soRefElement(buffer, offset, s.get());
        }
        return actualLimit;
    }

    @Override
    public int drain(Consumer<E> c) {
        return drain(c, capacity());
    }

    @Override
    public int fill(Supplier<E> s) {
        return MessagePassingQueueUtil.fillBounded(this, s);
    }

    @Override
    public void drain(Consumer<E> c, WaitStrategy w, ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, w, exit);
    }

    @Override
    public void fill(Supplier<E> s, WaitStrategy wait, ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    /**
     * @deprecated This was renamed to failFastOffer please migrate
     */
    @Deprecated
    public int weakOffer(E e) {
        return this.failFastOffer(e);
    }
}
