import React, { useState, useContext } from "react";
import { Form, Field } from "formik";
import { PageContext } from "../context/pageContext";


const Book: React.FC = () => {
  const [paragraph, setParagraph] = useState("");

  const { addParagraph, currentPage, setCurrentPage, pageNumber, total } = useContext(PageContext);

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    addParagraph(currentPage, paragraph);
    setParagraph("");
  };

  return (
    <div>
      <h1>Page {pageNumber}</h1>

      <div>{{currentPage}}</div>

      {pageNumber > 1 && (
        <button onClick={() => setCurrentPage(currentPage - 1)}>
          Previous
        </button>
      )}

      {pageNumber < total && (
        <button onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
      )}

      <Form onSubmit={handleSubmit}>
        <Field
          type="text"
          name="paragraph"
          value={paragraph}
          onChange={(e: { target: { value: React.SetStateAction<string> } }) =>
            setParagraph(e.target.value)
          }
        />
        <button type="submit">Add Paragraph</button>
      </Form>
    </div>
  );
};

export default Book;
