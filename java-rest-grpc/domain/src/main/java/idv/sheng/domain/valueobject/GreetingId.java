package idv.sheng.domain.valueobject;

import idv.sheng.domain.common.valueobject.BaseId;

import java.util.UUID;

public class GreetingId extends BaseId<UUID> {
    public GreetingId(UUID value) {
        super(value);
    }
}
