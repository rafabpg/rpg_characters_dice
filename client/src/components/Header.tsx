import React from 'react'
import { Link } from 'react-router-dom'; 

const Header = () => {

  return (
    <div className="bg-gray-600 p-4">
      <div className="max-w-7xl mx-auto flex justify-between items-center">
        <div className="flex items-center">
          <span className="text-white text-lg font-bold">RPG Manager</span>
        </div>
        <div className="flex space-x-4">
          <Link to="/personagens" className="text-gray-300  hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-bold">
            Meus Personagens
          </Link>
          <Link to="/campanhas" className="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-bold">
            Minhas Campanhas
          </Link>
          <Link to="/logout" className="text-gray-300 border-4 border-white hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-bold">
            Logout
          </Link>
        </div>
      </div>
    </div>
     

  )
}

export default Header