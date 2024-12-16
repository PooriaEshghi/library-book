
import './App.css'
import { HomePage } from './layout/HomePage/HomePage'
import { Footer } from './layout/NavbarAndFooter/Footer'
import Navbar from './layout/NavbarAndFooter/Navbar'

export const App = () => {

  return (
    <>
      <Navbar />

      <HomePage />
      <Footer />
    </>
  )
}

