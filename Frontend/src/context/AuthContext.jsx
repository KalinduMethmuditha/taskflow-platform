import { createContext, useState, useEffect, useContext } from 'react';

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [token, setToken] = useState(localStorage.getItem('jwt_token'));
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (token) {
            // Placeholder: in a real app, decode token or call /api/auth/me
            setUser({ name: 'Admin User', email: 'admin@taskflow.com' });
        } else {
            setUser(null);
        }
        setLoading(false);

        const handleUnauthorized = () => logout();
        window.addEventListener('auth:unauthorized', handleUnauthorized);
        return () => window.removeEventListener('auth:unauthorized', handleUnauthorized);
    }, [token]);

    const login = async (email, password) => {
        try {
            // If backend is ready, use authService:
            // const data = await authService.login(email, password);
            // const receivedToken = data.token;
            
            // Simulating API success for demonstration
            const receivedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.mock_token";
            setToken(receivedToken);
            localStorage.setItem('jwt_token', receivedToken);
            setUser({ name: 'Admin User', email });
            return { success: true };
        } catch (error) {
            return { success: false, error: error.response?.data?.message || 'Login failed' };
        }
    };

    const logout = () => {
        setToken(null);
        setUser(null);
        localStorage.removeItem('jwt_token');
    };

    return (
        <AuthContext.Provider value={{ user, token, isAuthenticated: !!token, login, logout, loading }}>
            {!loading && children}
        </AuthContext.Provider>
    );
};
