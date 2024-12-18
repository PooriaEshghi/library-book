
import { Route, Routes } from 'react-router-dom'
import './App.css'
import { HomePage } from './layout/HomePage/HomePage'
import { Footer } from './layout/NavbarAndFooter/Footer'
import { SearchBooksPage } from './layout/SearchBooksPage/SearchBooksPage'
import { Navbar } from './layout/NavbarAndFooter/Navbar'
import { BookCheckoutPage } from './layout/BookCheckoutPage/BookCheckoutPage'

export const App = () => {

  return (
    <div className='d-flex flex-column min-vh-100'>
      <Navbar />
      <div className='flex-grow-1'>

        <Routes>
          <Route index path='/' element={<HomePage />} />
          <Route path='/home' element={<HomePage />} />
          <Route path='/search' element={<SearchBooksPage />} />
          <Route path='/checkout/:bookId' element={<BookCheckoutPage />} />

        </Routes>
      </div>
      <Footer />

    </div>
  )
}

