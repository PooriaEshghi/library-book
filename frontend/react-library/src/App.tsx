
import { Route, Routes, Navigate, useNavigate } from 'react-router-dom';
import './App.css';

import { oktaConfig } from './lib/oktaConfig';
import { OktaAuth, toRelativeUrl } from '@okta/okta-auth-js';
import { Security, LoginCallback, SecureRoute } from '@okta/okta-react';
import { Navbar } from './layout/NavbarAndFooter/Navbar';
import { HomePage } from './layout/HomePage/HomePage';
import { SearchBooksPage } from './layout/SearchBooksPage/SearchBooksPage';
import { ReviewListPage } from './layout/ReviewListPage/ReviewListPage';
import { BookCheckoutPage } from './layout/BookCheckoutPage/BookCheckoutPage';
import { Footer } from './layout/NavbarAndFooter/Footer';
import { ShelfPage } from './layout/ShelfPage/ShelfPage';
// import LoginWidget from './LoginWidget';
import LoginWidget from './Auth/LoginWidget';
// import LoginWidget from './LoginWidget.jsx';


const oktaAuth = new OktaAuth(oktaConfig);

export const App = () => {
  const navigate = useNavigate();

  const customAuthHandler = () => {
    navigate('/login');
  };

  const restoreOriginalUri = async (_oktaAuth: any, originalUri: any) => {
    navigate(toRelativeUrl(originalUri || '/', window.location.origin));
  };

  return (
    <div className='d-flex flex-column min-vh-100'>
      <Security oktaAuth={oktaAuth} restoreOriginalUri={restoreOriginalUri} onAuthRequired={customAuthHandler}>
        <Navbar />
        <div className='flex-grow-1'>
          <Routes>
            <Route path='/' element={<Navigate to='/home' replace />} />
            <Route path='/home' element={<HomePage />} />
            <Route path='/search' element={<SearchBooksPage />} />
            <Route path='/reviewlist/:bookId' element={<ReviewListPage />} />
            <Route path='/checkout/:bookId' element={<BookCheckoutPage />} />
            <Route
              path='/login'
              element={<LoginWidget config={oktaConfig} />}
            />
            <Route path='/login/callback' element={<LoginCallback />} />
             <Route
              path='/shelf'
              element={
                <SecureRoute>
                  <ShelfPage />
                </SecureRoute>
              }
            />
            {/*<Route
              path='/messages'
              element={
                <SecureRoute>
                  <MessagesPage />
                </SecureRoute>
              }
            />
            <Route
              path='/admin'
              element={
                <SecureRoute>
                  <ManageLibraryPage />
                </SecureRoute>
              }
            /> */}
          </Routes>
        </div>
        <Footer />
      </Security>
    </div>
  );
};
