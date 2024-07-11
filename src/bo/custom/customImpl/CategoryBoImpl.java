package bo.custom.customImpl;

import java.util.ArrayList;

import bo.custom.CategoryBo;
import dao.DaoFactory;
import dao.custom.Categorydao;
import dto.CategoryDto;
import entity.Category;

public class CategoryBoImpl implements CategoryBo {

    Categorydao categorydao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.CATEGORY);


    @Override
    public boolean saveCategory(CategoryDto CategoryDTO) throws Exception {
        return categorydao.save(new Category(CategoryDTO.getCategoryID(),CategoryDTO.getCategoryName()));
    }

    @Override
    public boolean updateCategory(CategoryDto CategoryDTO) throws Exception {
      return categorydao.update(new Category(CategoryDTO.getCategoryID(), CategoryDTO.getCategoryName()));
    }

    @Override
    public boolean deleteCategory(Integer id) throws Exception {
       return categorydao.delete(id);
    }

    @Override
    public CategoryDto getCategory(Integer id) throws Exception {
      Category category = categorydao.get(id);
      if(category != null){
        return new CategoryDto(category.getCategoryID(), category.getCategoryName());
      }
      return null;
    }

    @Override
    public ArrayList<CategoryDto> getAllCategory() throws Exception {
        ArrayList<Category> categoryEntity = categorydao.getAll();
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();

        for(Category cat: categoryEntity){
            CategoryDto categoryDto = new CategoryDto(cat.getCategoryID(), cat.getCategoryName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryByCategoryname(String Categoryname) throws Exception {
       
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryByCategoryname'");
    }
    
}
