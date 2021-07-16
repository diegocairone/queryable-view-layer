package com.cairone.qvl.core.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.util.Streamable;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageModel<T> implements Streamable<T> {

    public static <T> PageModel<T> of(Page<T> page) {
        return new PageModel<>(page);
    }
    
    public static <T> PageModel<T> of(List<T> collection) {
        return new PageModel<>(new PageImpl<>(collection));
    }

    private List<T> content;

    private Long totalElements;

    private Boolean last;

    private PageModel(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();
    }

    private <U> List<U> getConvertedContent(Function<? super T, ? extends U> converter) {

        Assert.notNull(converter, "Function must not be null!");
        return this.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public <U> PageModel<U> map(Function<? super T, ? extends U> converter) {

        return new PageModel<>(getConvertedContent(converter), totalElements, last);
    }

    @Override
    public Iterator<T> iterator() {

        return content.iterator();
    }

}
