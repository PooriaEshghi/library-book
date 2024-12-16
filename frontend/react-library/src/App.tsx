
import './App.css'
import { Carousel } from './layout/HomePage/components/Carousel'
import { ExploreTopBooks } from './layout/HomePage/components/ExploreTopBooks'
import { Heros } from './layout/HomePage/components/Heros'
import Navbar from './layout/NavbarAndFooter/Navbar'

function App() {

  return (
    <>
      <Navbar />
      <ExploreTopBooks />
      <Carousel />
      <Heros/>
    </>
  )
}

export default App
