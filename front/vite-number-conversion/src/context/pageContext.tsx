import React, { createContext, useState } from 'react';

interface PageContextProps {
  pageNumber: number;
  currentPage:string;
  phrases:string[];
  addParagraph: (pageNumber: number, paragraph: string) => void;
  setCurrentPageNumber: (pageNumber: number) => void;
  total: number;
}

 
export const PageContext = createContext<PageContextProps>({
    pageNumber: 0,
    total:0,
    currentPage:"",
    phrases: [],
    addParagraph: () => {},
    setCurrentPageNumber: () => {}
  });

interface PageContextProviderProps {
    children: React.ReactNode;
}

const PageContextProvider: React.FC<PageContextProviderProps> = ({ children }) => {
  const [pageNumber, setPageNumber] = useState(0);
  const [currentPage, setCurrentPage] = useState("");

  const [currentPage, setCurrentPage] = useState("");

  //make API call to get the paragraphs
  
  //m

  

  const addParagraph = (pageNumber: number, paragraph: string) => {
    // Make API call to add paragraph to page
  };

  const setCurrentPageNumber = (pageNumber: number) => {
    setPageNumber(pageNumber);
  };

  return (
    <PageContext.Provider value={{ pageNumber, addParagraph, setCurrentPageNumber }}>
      {children}
    </PageContext.Provider>
  );
};

export default PageContextProvider;