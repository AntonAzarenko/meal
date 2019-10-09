package com.azarenka.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Base Entity
 * <p>
 * <p>
 * (c) ant-azarenko@mail.ru
 * </p>
 *
 * @author Anton Azarnko
 * @Date 21.07.2019
 */
public class BaseEntity {

    private String id;

    /**
     * Default constructor.
     */
    public BaseEntity() {
    }

    /**
     * Gets entity id.
     *
     * @return entity id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets entity id.
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
