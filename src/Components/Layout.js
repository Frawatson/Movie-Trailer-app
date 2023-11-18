import { Outlet } from "react-router-dom";
import React from "react";

/**
 * Renders the main layout of the application.
 *
 * @return {JSX.Element} The main layout component.
 */
const Layout = () => {
    return (
        <main>
            <Outlet/>
        </main>
    )
}

export default Layout