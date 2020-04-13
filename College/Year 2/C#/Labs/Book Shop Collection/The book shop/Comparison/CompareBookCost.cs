using System.Collections;
using System.Collections.Generic;

namespace The_book_shop.Comparison
{
    public class CompareBookCost : IComparer<Book>
    {
        public int Compare(Book x, Book y)
        {
            return x.CalculateCost().CompareTo(y.CalculateCost());
        }
    }
}