
import React from 'react'
import { BrowserRouter, Route,Routes } from 'react-router-dom'
import { LayoutTemplate } from '../templates/Layout'
import { Home } from '../pages/Home'

export const RoutesApp = () => {
  return (

    <BrowserRouter>
        <Routes>
          <Route path="/" element={<LayoutTemplate/>}>
            <Route path='/' element={<Home/>} />
          </Route>
        </Routes>
    </BrowserRouter>


  )
}
