package bo.custom;

import java.util.ArrayList;

import dto.CategoryDto;



public interface CategoryBo {
    public boolean saveCategory(CategoryDto CategoryDTO) throws Exception;

    public boolean updateCategory(CategoryDto CategoryDTO) throws Exception;

    public boolean deleteCategory(Integer id) throws Exception;

    public CategoryDto getCategory(Integer id) throws Exception;

    public ArrayList<CategoryDto> getAllCategory() throws Exception;

    public CategoryDto  getCategoryByCategoryname(String Categoryname) throws Exception;
}
