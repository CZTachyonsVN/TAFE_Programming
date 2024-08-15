
using TypicalTechTools.Models.Data;

namespace TypicalTechTools.Models.Repository
{
    public class CommentRepository : ICommentRepository
    {
        private readonly TypicalTechToolsDB_Context _context;

        public CommentRepository(TypicalTechToolsDB_Context context)
        {
            _context = context;
        }

        public void AddComment(Comment comment)
        {
            _context.Comments.Add(comment);
        }

        public List<Comment> GetAllComments()
        {
            return _context.Comments.ToList();
        }

        public Comment GetCommentById(int id)
        {
            return _context.Comments.FirstOrDefault(c => c.Id == id);
        }

        public List<Comment> GetCommentsOfProduct(int productId)
        {
            return _context.Comments.Where(c => c.ProductCode == productId).ToList();
        }

    }
}
