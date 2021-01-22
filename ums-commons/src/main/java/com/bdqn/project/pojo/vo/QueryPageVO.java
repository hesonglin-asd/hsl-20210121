package com.bdqn.project.pojo.vo;

import java.io.Serializable;

/**
 * <b>查询分页视图</b>
 * <p>
 *     在使用 Spring Cloud 在远程调用时，产生纪要分页查询，又会进行按照条件查询，<br/>
 *     那么就会传递两个对象，一个是分页对象，一个是查询对象，而 Spring Cloud 只能传递一个 JSON <br/>
 *     因此本视图是将两个对象合成为一个，以便进行传输
 * </p>
 * @param <E>
 */
public class QueryPageVO<E> implements Serializable {
	private static final long serialVersionUID = -6583590839996687240L;
	private PageVO<E> pageVO;                       // 分页视图
	private E query;                                // 查询对象

	public QueryPageVO() {}
	public QueryPageVO(PageVO<E> pageVO, E query) {
		this.pageVO = pageVO;
		this.query = query;
	}

	public PageVO<E> getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO<E> pageVO) {
		this.pageVO = pageVO;
	}

	public E getQuery() {
		return query;
	}

	public void setQuery(E query) {
		this.query = query;
	}
}
