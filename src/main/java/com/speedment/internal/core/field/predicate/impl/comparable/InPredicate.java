/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.internal.core.field.predicate.impl.comparable;

import static com.speedment.field.predicate.PredicateType.IN;
import com.speedment.field.predicate.ComparableSpeedmentPredicate;
import com.speedment.field.predicate.SpeedmentPredicate;
import com.speedment.field.trait.FieldTrait;
import com.speedment.field.trait.ReferenceFieldTrait;
import com.speedment.internal.core.field.predicate.impl.SpeedmentPredicateImpl;
import java.util.Set;
import com.speedment.internal.core.field.predicate.iface.type.BinarySetOperation;
    
/**
 *
 * @author pemi
 * @param <ENTITY> the entity type
 * @param <V> value type
 */
public class InPredicate<ENTITY, V extends Comparable<? super V>>
    extends SpeedmentPredicateImpl<ENTITY, V>
    implements SpeedmentPredicate<ENTITY, V>, BinarySetOperation<V>, ComparableSpeedmentPredicate<ENTITY, V> {

    private final Set<V> operand0;

    public InPredicate(FieldTrait field, ReferenceFieldTrait<ENTITY, V> referenceField, Set<V> values) {
        super(IN, field, referenceField);
        this.operand0 = values;
    }

    @Override
    public Set<V> getFirstOperand() {
        return operand0;
    }

    @Override
    public boolean testField(V fieldValue) {
        return operand0.contains(fieldValue);
    }

}
