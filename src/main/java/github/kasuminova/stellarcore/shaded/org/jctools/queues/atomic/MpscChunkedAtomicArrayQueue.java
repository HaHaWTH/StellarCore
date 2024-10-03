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

import github.kasuminova.stellarcore.shaded.org.jctools.util.Pow2;
import github.kasuminova.stellarcore.shaded.org.jctools.util.RangeUtil;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static github.kasuminova.stellarcore.shaded.org.jctools.util.Pow2.roundToPowerOfTwo;
import java.util.concurrent.atomic.*;
import github.kasuminova.stellarcore.shaded.org.jctools.queues.*;
import static github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.AtomicQueueUtil.*;

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscChunkedArrayQueue.java.
 */
abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueue<E> {

    protected final long maxQueueCapacity;

    MpscChunkedAtomicArrayQueueColdProducerFields(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        RangeUtil.checkGreaterThanOrEqual(maxCapacity, 4, "maxCapacity");
        RangeUtil.checkLessThan(roundToPowerOfTwo(initialCapacity), roundToPowerOfTwo(maxCapacity), "initialCapacity");
        maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(maxCapacity)) << 1;
    }
}

/**
 * NOTE: This class was automatically generated by github.kasuminova.stellarcore.shaded.org.jctools.queues.atomic.JavaParsingAtomicLinkedQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscChunkedArrayQueue.java.
 *
 * An MPSC array queue which starts at <i>initialCapacity</i> and grows to <i>maxCapacity</i> in linked chunks
 * of the initial size. The queue grows only when the current chunk is full and elements are not copied on
 * resize, instead a link to the new chunk is stored in the old chunk for the consumer to follow.
 */
public class MpscChunkedAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueueColdProducerFields<E> {

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

    public MpscChunkedAtomicArrayQueue(int maxCapacity) {
        super(max(2, min(1024, roundToPowerOfTwo(maxCapacity / 8))), maxCapacity);
    }

    /**
     * @param initialCapacity the queue initial capacity. If chunk size is fixed this will be the chunk size.
     *                        Must be 2 or more.
     * @param maxCapacity     the maximum capacity will be rounded up to the closest power of 2 and will be the
     *                        upper limit of number of elements in this queue. Must be 4 or more and round up to a larger
     *                        power of 2 than initialCapacity.
     */
    public MpscChunkedAtomicArrayQueue(int initialCapacity, int maxCapacity) {
        super(initialCapacity, maxCapacity);
    }

    @Override
    protected long availableInQueue(long pIndex, long cIndex) {
        return maxQueueCapacity - (pIndex - cIndex);
    }

    @Override
    public int capacity() {
        return (int) (maxQueueCapacity / 2);
    }

    @Override
    protected int getNextBufferSize(AtomicReferenceArray<E> buffer) {
        return length(buffer);
    }

    @Override
    protected long getCurrentBufferCapacity(long mask) {
        return mask;
    }
}
