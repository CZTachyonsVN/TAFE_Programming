
using TypicalTechTools.Models.Data;

namespace TypicalTechTools.Models.Repository
{
    public class ProductRepository : IProductRepository
    {
        private readonly TypicalTechToolsDB_Context _context;

        public ProductRepository(TypicalTechToolsDB_Context context)
        {
            _context = context;
        }

        public List<Product> GetAllProucts()
        {
            //TODO: remember to include product comments.
            return _context.Products.ToList();
        }

        public Product GetProductById(int id)
        {
            return _context.Products.Where(p => p.Id == id).FirstOrDefault();
        }
    }
}
