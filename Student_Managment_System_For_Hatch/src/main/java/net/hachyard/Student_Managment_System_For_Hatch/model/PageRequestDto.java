package net.hachyard.Student_Managment_System_For_Hatch.model;

import java.util.Objects;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDto {
	
	private Integer pageNo =0;
	private Integer pageSize=5;
	private Sort.Direction sort=Sort.Direction.ASC;
	private String sortByColumn="id";
	
	public Sort.Direction getSort() {
		return sort;
	}
	public void setSort(Sort.Direction sort) {
		this.sort = sort;
	}
	public String getSortByColumn() {
		return sortByColumn;
	}
	public void setSortByColumn(String sortByColumn) {
		this.sortByColumn = sortByColumn;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageRequestDto [pageNo=" + pageNo + ", pageSize=" + pageSize + ", sort=" + sort + ", sortByColumn="
				+ sortByColumn + ", getSort()=" + getSort() + ", getSortByColumn()=" + getSortByColumn()
				+ ", getPageNo()=" + getPageNo() + ", getPageSize()=" + getPageSize() + "]";
	}
	public Pageable getPageble(PageRequestDto dto) {
		Integer page=Objects.nonNull(dto.getPageNo())?dto.getPageNo() :this.pageNo;
		Integer size=Objects.nonNull(dto.getPageSize())?dto.getPageSize() :this.pageSize;
		Sort.Direction sort=Objects.nonNull(dto.getSort())?dto.getSort() :this.sort;
		String sortByColumn=Objects.nonNull(dto.getSortByColumn())?dto.getSortByColumn() :this.sortByColumn;		
		PageRequest request=PageRequest.of(page,size,sort,sortByColumn);
		return request;
	}
	
	
}
