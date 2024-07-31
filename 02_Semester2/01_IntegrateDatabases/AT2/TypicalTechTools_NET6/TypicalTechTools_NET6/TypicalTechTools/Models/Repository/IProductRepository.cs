namespace TypicalTechTools.Models.Repository
{
    public interface IProductRepository
    {
        List<Product> GetAllProucts();
        Product GetProductById(int id);

    }
}
