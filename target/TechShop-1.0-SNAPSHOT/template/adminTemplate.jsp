<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.tailwindcss.com"></script>
        <link href="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.css" rel="stylesheet" />
        <title>Admin Dashboard - Clothing Shop</title>
    </head>
    <body class="bg-gray-50">

        <button data-drawer-target="separator-sidebar" data-drawer-toggle="separator-sidebar" aria-controls="separator-sidebar" type="button" class="inline-flex items-center p-2 mt-2 ms-3 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200">
            <span class="sr-only">Open sidebar</span>
            <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
            </svg>
        </button>

        <aside id="separator-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0" aria-label="Sidebar">
            <div class="h-full px-3 py-4 overflow-y-auto bg-white border-r border-gray-200">
                <div class="flex items-center ps-2.5 mb-5">
                    <span class="self-center text-xl font-semibold whitespace-nowrap text-blue-600">G5 Clothing Admin</span>
                </div>

                <ul class="space-y-2 font-medium">
                    <li>
                        <a href="dashboard" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
                            <svg class="w-5 h-5 text-gray-500 transition duration-75 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 21">
                            <path d="M16.975 11H10V4.025a1 1 0 0 0-1.066-.998 8.5 8.5 0 1 0 9.039 9.039.999.999 0 0 0-1-1.066h.002Z"/>
                            <path d="M12.5 0c-.157 0-.311.01-.565.027A1 1 0 0 0 11 1.02V10h8.975a1 1 0 0 0 1-.935c.013-.188.028-.374.028-.565A8.51 8.51 0 0 0 12.5 0Z"/>
                            </svg>
                            <span class="ms-3">Dashboard</span>
                        </a>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-user" data-collapse-toggle="dropdown-user">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 18">
                            <path d="M14 2a3.963 3.963 0 0 0-1.4.267 6.439 6.439 0 0 1-1.331 6.638A4 4 0 1 0 14 2Zm1 9h-1.264A6.957 6.957 0 0 1 15 15v2a2.97 2.97 0 0 1-.184 1H19a1 1 0 0 0 1-1v-1a5.006 5.006 0 0 0-5-5ZM6.5 9a4.5 4.5 0 1 0 0-9 4.5 4.5 0 0 0 0 9ZM8 10H5a5.006 5.006 0 0 0-5 5v2a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-2a5.006 5.006 0 0 0-5-5Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Người dùng</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-user" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="user?action=list" class="hover:text-blue-600 block py-1">Danh sách</a></li>
                            <li><a href="user?action=add" class="hover:text-blue-600 block py-1">Thêm mới</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-product" data-collapse-toggle="dropdown-product">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 20">
                            <path d="M17 5.923A1 1 0 0 0 16 5h-3V4a4 4 0 1 0-8 0v1H2a1 1 0 0 0-1 .923L.086 17.846A2 2 0 0 0 2.08 20h13.84a2 2 0 0 0 1.994-2.153L17 5.923ZM7 9a1 1 0 0 1-2 0V7h2v2Zm0-5a2 2 0 1 1 4 0v1H7V4Zm6 5a1 1 0 1 1-2 0V7h2v2Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Sản phẩm</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-product" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="product?action=list" class="hover:text-blue-600 block py-1">Kho hàng</a></li>
                            <li><a href="product?action=add" class="hover:text-blue-600 block py-1">Nhập sản phẩm</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-category" data-collapse-toggle="dropdown-category">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path d="M18 5h-7V2a1 1 0 0 0-2 0v3H2a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Danh mục</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-category" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="category?action=list" class="hover:text-blue-600 block py-1">Tất cả danh mục</a></li>
                            <li><a href="category?action=add" class="hover:text-blue-600 block py-1">Thêm danh mục</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-brand" data-collapse-toggle="dropdown-brand">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path d="M7 2a2 2 0 0 0-2 2v1H2a2 2 0 0 0-2 2v11a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-3V4a2 2 0 0 0-2-2H7Zm0 2h6v1H7V4Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Thương hiệu</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-brand" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="brand?action=list" class="hover:text-blue-600 block py-1">Danh sách hãng</a></li>
                            <li><a href="brand?action=add" class="hover:text-blue-600 block py-1">Thêm hãng</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-promotion" data-collapse-toggle="dropdown-promotion">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                            <path d="M11.074 4 8.442.47a1 1 0 0 0-1.588 0L4.223 4H11.074ZM2 6v4a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V6H2Zm14 3a1 1 0 1 1 0 2 1 1 0 0 1 0-2ZM5 9a1 1 0 1 1 0 2 1 1 0 0 1 0-2Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Khuyến mãi</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-promotion" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="promotion?action=list" class="hover:text-blue-600 block py-1">Danh sách mã</a></li>
                            <li><a href="promotion?action=add" class="hover:text-blue-600 block py-1">Tạo mã mới</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-order" data-collapse-toggle="dropdown-order">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 20">
                            <path d="M16 1h-3.278A1.992 1.992 0 0 0 11 0H7a1.993 1.993 0 0 0-1.722 1H2a2 2 0 0 0-2 2v15a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2ZM7 2h4v3H7V2Zm5.7 8.289-3.975 3.857a1 1 0 0 1-1.393 0L5.3 12.182a1.002 1.002 0 1 1 1.4-1.436l1.328 1.289 3.28-3.181a1 1 0 1 1 1.392 1.435Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Đơn hàng</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-order" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="order?action=list" class="hover:text-blue-600 block py-1">Tất cả đơn hàng</a></li>
                            <li><a href="order?status=pending" class="hover:text-blue-600 block py-1">Chờ xử lý</a></li>
                        </ul>
                    </li>

                    <li>
                        <button type="button" class="flex items-center w-full p-2 text-base text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100" aria-controls="dropdown-cart" data-collapse-toggle="dropdown-cart">
                            <svg class="shrink-0 w-5 h-5 text-gray-500 group-hover:text-blue-600" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 21">
                            <path d="M15 12a1 1 0 0 0 .962-.726l2-7A1 1 0 0 0 17 3H3.77L3.175.745A1 1 0 0 0 2.208 0H1a1 1 0 0 0 0 2h.438l.6 2.255v.019l2 7 .746 2.986A3 3 0 1 0 9 17a2.966 2.966 0 0 0-.184-1h2.368c-.118.32-.184.653-.184 1a3 3 0 1 0 3-3H6.78l-.5-2H15Z"/>
                            </svg>
                            <span class="flex-1 ms-3 text-left whitespace-nowrap">Giỏ hàng</span>
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/></svg>
                        </button>
                        <ul id="dropdown-cart" class="hidden py-2 space-y-2 pl-11 text-sm">
                            <li><a href="cart?action=active" class="hover:text-blue-600 block py-1">Đang hoạt động</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="pt-4 mt-4 space-y-2 font-medium border-t border-gray-200">
                    <li>
                        <a href="logout" class="flex items-center p-2 text-red-600 rounded-lg hover:bg-red-50 group">
                            <svg class="w-5 h-5 transition duration-75" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 16">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 8h11m0 0L8 4m4 4-4 4m4-11h3a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-3"/>
                            </svg>
                            <span class="ms-3">Đăng xuất</span>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>

        <div class="p-4 sm:ml-64">
            <div class="p-4 border-2 border-gray-200 border-dashed rounded-lg mt-3 bg-white shadow-sm min-h-[85vh]">
              <jsp:include page="${contentPage}" />
              <h1>a</h1>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/flowbite@2.5.2/dist/flowbite.min.js"></script>
    </body>
</html>