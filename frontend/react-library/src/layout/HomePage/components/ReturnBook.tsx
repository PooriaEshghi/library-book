
// import BookModel from '../../../models/BookModel';

export const ReturnBook = () => {
    return (
        <div className='col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3'>
            <div className='text-center'>
                
                    
                    <img
                        src='./../../../Images/BooksImages/book-luv2code-1000.png'
                        width='151'
                        height='233'
                        alt="book"
                    />
                
                <h6 className='mt-2'>Book</h6>
                <p>JavaScript</p>
                {/* <a className='btn main-color text-white' href={`checkout/${props.book.id}`}>Reserve</a> */}
            </div>
        </div>
    );
}