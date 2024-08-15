namespace TypicalTechTools.Models.Repository
{
    public interface ICommentRepository
    {
        List<Comment> GetAllComments();
        List<Comment> GetCommentsOfProduct(int productId);
        Comment GetCommentById(int id);
        void AddComment(Comment comment);

    }
}
